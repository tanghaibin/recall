package top.tanghaibin.parser.api;


import top.tanghaibin.exception.BizException;

/**
 *	转换器，内部使用
 */
public interface Converter {
	/**
	 * 字符串转换成对象
	 * @param text
	 * @param clazz
	 * @param <T>
	 * @return
	 * @throws BizException
	 */
	public <T> T fromResponse(String text, Class<T> clazz)throws BizException;

	/**
	 * 对象转换成字符串
	 * @param obj
	 * @param <T>
	 * @return
	 * @throws BizException
	 */
	public <T> String toResponse(Object obj)throws BizException;
}