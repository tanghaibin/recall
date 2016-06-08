package top.tanghaibin.recall.context;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.util.StringUtil;
import top.tanghaibin.cons.Constants;
import top.tanghaibin.string.RandomUtils;
import top.tanghaibin.utils.CommonUtil;
import top.tanghaibin.utils.DateUtils;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;


/**
 * Created by tangh on 2016/5/1.
 */
@Controller
@RequestMapping("upload")
public class UploadController {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    private static final top.tanghaibin.parser.json.JsonParser jsonParser = new  top.tanghaibin.parser.json.JsonParser();
    private static String imagePath = null;
    private static String filePath = null;

    static{
        try {
            URL url = UploadController.class.getResource("/uploadPath.json");
            InputStream inputStream = url.openStream();
            Map<String,List<Map<String,String>>> map = jsonParser.to(inputStream,Map.class);
            imagePath = map.get("path").get(0).get("image");
            filePath = map.get("path").get(0).get("file");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传图片
     * @param file
     * @return
     */
    @RequestMapping("uploadImage")
    public @ResponseBody
    ResponseEntity<String> uploadImage(MultipartFile file){
        if(null == file) return new ResponseEntity<String>(Constants.EX_PARAM, HttpStatus.BAD_REQUEST);
        try {
            String filename = file.getOriginalFilename();
            String currentDate = DateUtils.DATE_PATTERN();
            String newImageName = RandomUtils.getRandomStr()+filename.substring(filename.lastIndexOf("."), filename.length());
            File dir = new File(imagePath+File.separator+"recall"+File.separator+currentDate+File.separator);
            if(dir.isDirectory()){
                if(!dir.exists()){
                    dir.mkdir();
                }
            }
            File outFile = new File(imagePath+File.separator+"recall"+File.separator+currentDate+File.separator+newImageName);
            FileUtils.copyInputStreamToFile(file.getInputStream(),outFile);
            return new ResponseEntity<String>("recall/"+currentDate+"/"+newImageName,HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<String>(Constants.EX_APP,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 上传文件
     * @param file
     * @return
     */
    @RequestMapping("uploadFile")
    public @ResponseBody String uploadFile(MultipartFile file){
        return "";
    }

}
