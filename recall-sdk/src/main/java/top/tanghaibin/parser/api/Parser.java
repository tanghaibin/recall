package top.tanghaibin.parser.api;

import top.tanghaibin.exception.BizException;

/**
 * 格式转换器，如xml、json转换
 */
public interface Parser {
	/**
	 * 格式字符串转成对象
	 * @param text
	 * @param clazz
	 * @param <T>
	 * @return
	 * @throws BizException
	 */
	public <T> T from(String text, Class<T> clazz)throws BizException;
	/**
	 * 对象转出字符串
	 * @param obj
	 * @param <T>
	 * @return
	 * @throws BizException
	 */
	public <T> String to(Object obj)throws BizException;
}