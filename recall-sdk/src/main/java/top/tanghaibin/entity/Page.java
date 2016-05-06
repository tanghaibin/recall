package top.tanghaibin.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangh on 2016/5/1.
 */
public class Page<T> {
    private int pageNumber;
    private int pageSize;
    private long total;
    private List<T> rows = new ArrayList<T>();

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
