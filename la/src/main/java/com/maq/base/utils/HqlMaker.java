package com.maq.base.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 
 *	组装hql语句,继承公共的HqlMarker，扩展了Map方法查询，防止SQL注入 <br/>
 *  @author llchen@iflytek.com
 *  @created 2015-2-2 下午02:20:40
 *  @lastModified       
 *  @history
 */
@SuppressWarnings("unchecked")
public class HqlMaker {

	/*** 分隔符号--百分号 ***/
	private static final String SPLIT_FLAG_BFH = "%";

	/**
	 * 
	 * getInitArrayList:(获得ArrayList对象). <br/>
	 * 
	 * @author hxyu
	 * @param className
	 *            查询的类名称，不能为空
	 * @param whereCodtion
	 *            带有where的查询条件，例如：where sczt=1，没有默认条件可以设置为"",如果为""自动在后面加个where
	 *            1=1条件
	 * @return Vector<Object>
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> getInitArrayList(String className,
			String whereCodtion) {
		ArrayList<Object> arrayList = new ArrayList<Object>(2);
		StringBuilder hql = new StringBuilder(128);
		Map<String, Object> values = new HashMap<String, Object>();
		hql.append("from ");
		hql.append(className);
		if (StringUtils.isNotBlank(whereCodtion)) {
			// 加个空格防止类名称跟where连在一块
			hql.append(" ");
			hql.append(whereCodtion);
		} else {
			hql.append(" where 1=1 ");
		}
		arrayList.add(0, hql);
		arrayList.add(1, values);
		return arrayList;
	}
	
	public static ArrayList<Object> getInitArrayList(String className) {
		return getInitArrayList(className,null);
	}

	/**
	 * 
	 * popuHqlLike:(全模糊查询). <br/>
	 * 
	 * @author hxyu
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            存放查询的Hql和Map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuHqlLike(String column, String param,
			ArrayList<Object> arrayList) {
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and ").append(column).append(" like :").append(
					column.replaceAll("\\.", ""));
			values.put(column.replaceAll("\\.", ""), SPLIT_FLAG_BFH + param
					+ SPLIT_FLAG_BFH);
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}

	/**
	 * 
	 * popuHqlNotRLike:(全模糊查询). <br/>
	 * 
	 * @author hxyu
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            存放查询的Hql和Map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuHqlNotRLike(String column,
			String param, ArrayList<Object> arrayList) {
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and ").append(column).append(" not like :").append(
					column.replaceAll("\\.", ""));
			values.put(column.replaceAll("\\.", ""), SPLIT_FLAG_BFH
					+ param.trim() + SPLIT_FLAG_BFH);
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}

	/**
	 * 
	 * popuHqlRLike:(右模糊查询). <br/>
	 * 
	 * @author hxyu
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            存放查询的Hql和Map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuHqlRLike(String column, String param,
			ArrayList<Object> arrayList) {
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and ").append(column).append("  like :").append(
					column.replaceAll("\\.", ""));
			values.put(column.replaceAll("\\.", ""), param.trim()
					+ SPLIT_FLAG_BFH);
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}

	/**
	 * 
	 * popuHqlOrgLikeNoOperator:(全模糊查询：没有运算符 and或者or). <br/>
	 * 
	 * @author hxyu
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            存放查询的Hql和Map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuHqlOrgLikeNoOperator(String column,
			String param, ArrayList<Object> arrayList) {
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and ").append(column).append("  like :").append(
					column.replaceAll("\\.", ""));
			values.put(column.replaceAll("\\.", ""), SPLIT_FLAG_BFH
					+ param.trim() + SPLIT_FLAG_BFH);
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}


	/**
	 * 
	 * popuHqlEq:(组装equals hql eg:col='param'). <br/>
	 * 
	 * @author hxyu
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            hql和map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuHqlEq(String column, String param,
			ArrayList<Object> arrayList) {
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and ").append(column).append(" =:").append(
					column.replaceAll("\\.", ""));
			values.put(column.replaceAll("\\.", ""), param.trim());
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}

	/**
	 * 
	 * popuHqlSfzhLike:(身份证号查询,18位精确查询否则右模糊). <br/>
	 * 
	 * @author hxyu
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            hql和map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuHqlSfzhLike(String column,
			String param, ArrayList<Object> arrayList) {
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			if (param.toUpperCase().length() == 18) {
				hql.append(" and ").append(column).append(" =:").append(
						column.replaceAll("\\.", ""));
				values.put(column.replaceAll("\\.", ""), param.trim()
						.toUpperCase());
			} else {
				hql.append(" and ").append(column).append(" like :").append(
						column.replaceAll("\\.", ""));
				values.put(column.replaceAll("\\.", ""), param.trim()
						.toUpperCase()
						+ SPLIT_FLAG_BFH);
			}

			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}

	/**
	 * 
	 * popuHqlNe:(组装equals hql eg:col!='param'). <br/>
	 * 
	 * @author hxyu
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            hql和map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuHqlNe(String column, String param,
			ArrayList<Object> arrayList) {
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and ").append(column).append(" !=:").append(
					column.replaceAll("\\.", ""));
			values.put(column.replaceAll("\\.", ""), param.trim());
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}

	/**
	 * 
	 * popuHqlNe:(组装equals hql eg:col!='param'). <br/>
	 * 
	 * @author hxyu
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            hql和map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuHqlNe(String column, Long param,
			ArrayList<Object> arrayList) {
		if (null != param && arrayList.size() > 1) {
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and ").append(column).append(" !=:").append(
					column.replaceAll("\\.", ""));
			values.put(column.replaceAll("\\.", ""), param);
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}

	/**
	 * 
	 * popuBeginDateHql:(查询的开始时间,按日期日期格式查询). <br/>
	 * 
	 * @author hxyu
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            hql和map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuBeginDateHql(String column,
			String param, ArrayList<Object> arrayList) {
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and ").append(column).append(
					" >=to_date(:beginDate,'YYYY-MM-DD HH24:MI:SS')");
			values.put("beginDate", param + " 00:00:00 ");
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}

	/**
	 * 
	 * popuBeginStringDateHql:(查询的开始时间,按字符串日期格式查询). <br/>
	 * 
	 * @author hxyu
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            hql和map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuBeginStringDateHql(String column,
			String param, ArrayList<Object> arrayList) {
		//String formatDate = "";
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			String inParam = param.replaceAll("-", "").replaceAll(":", "")
					.replaceAll(" ", "");
			//update by phy on 2015-02-04  begin 
			/*if (inParam.length() == 12) {
				formatDate = "00";
			} else if (inParam.length() == 10) {
				formatDate = "0000";
			} else if (inParam.length() == 8) {
//				formatDate = "000000";
				formatDate = "";
			}*/
			//update by phy on 2015-02-04  end 
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and ").append(column).append(" >=:beginStrDate");
			//values.put("beginStrDate", inParam + formatDate);
			values.put("beginStrDate", inParam);
		}
		return arrayList;
	}

	/**
	 * 
	 * popuEndDateHql:(查询的结束时间,按日期日期格式查询). <br/>
	 * 
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            hql和map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuEndDateHql(String column, String param,
			ArrayList<Object> arrayList) {
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and ").append(column).append(
					" <=to_date(:endDate,'YYYY-MM-DD HH24:MI:SS')");
			//values.put("endDate", param + " 00:00:00 ");
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}

	/**
	 * 
	 * popuEndStringDateHql:(查询的结束时间,按字符串日期格式查询). <br/>
	 * 
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            hql和map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuEndStringDateHql(String column,
			String param, ArrayList<Object> arrayList) {
		//String formatDate = "";
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			String inParam = param.replace("-", "").replace(":", "").replace(
					" ", "");
			//update by phy on 2015-02-04 begin
			/*if (param.length() == 12) {
				formatDate = "59";
			} else if (param.length() == 8) {
				formatDate = "235959";
			} else if (param.length() == 10) {
				formatDate = "5959";
			}*/
			//update by phy on 2015-02-04 end
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and ").append(column).append(" <=:endStrDate");
			//values.put("endStrDate", inParam + formatDate);
			values.put("endStrDate", inParam);
		}
		return arrayList;
	}

	/**
	 * 
	 * popuBeginIntegerHql:(查询开始,按数字格式查询). <br/>
	 * 
	 * @author hxyu
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            hql和map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuBeginIntegerHql(String column,
			String param, ArrayList<Object> arrayList) {
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and to_number(").append(column).append(") >=:")
					.append(column.replaceAll("\\.", ""));
			values.put(column.replaceAll("\\.", ""), Integer.parseInt(param));
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}

	/**
	 * 
	 * popuEndIntegerHql:(查询结束,按数字格式查询). <br/>
	 * 
	 * @author hxyu
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            hql和map值
	 * @return vector
	 * @since JDK 1.6
	 */
	public static ArrayList<Object> popuEndIntegerHql(String column,
			String param, ArrayList<Object> arrayList) {
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and to_number(").append(column).append(") <=:")
					.append(column.replaceAll("\\.", ""));
			values.put(column.replaceAll("\\.", ""), Integer.parseInt(param));
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}

	/**
	 * 
	 * popuHqlLikeCzjg:(处置结果右模糊). <br/>
	 * 
	 * @author hxyu
	 * @param column
	 *            列名称
	 * @param param
	 *            参数值
	 * @param arrayList
	 *            hql和map值
	 * @return vector
	 * @since JDK 1.6
	 */
	
	public static ArrayList popuHqlLikeCzjg(String column, String param,
			ArrayList<Object> arrayList) {
		if (StringUtils.isNotBlank(param) && arrayList.size() > 1) {
			String inParam = "";
			if ("0".equals(param.substring(param.length() - 1, param.length()))) {
				inParam = param.substring(0, param.length() - 1) + "_";
			}
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and ").append(column).append(" like :").append(
					column.replaceAll("\\.", ""));
			values.put(column.replaceAll("\\.", ""), inParam + SPLIT_FLAG_BFH);
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}

	/**
	 * 
	 * AddOtherCondition:(添加其他特殊的查询条件). <br/>
	 * 
	 * @author hxyu
	 * @param otherHql
	 *            拼接好的hql语句
	 * @param param
	 *            hql占位符或者叫参数名称
	 * @param value
	 *            占位符对应的指
	 * @param arrayList
	 *            hql和map值
	 * @return ArrayList
	 * @since JDK 1.6
	 */
	public static ArrayList addOtherCondition(String otherHql, String param,
			String value, ArrayList<Object> arrayList) {
		if (StringUtils.isNotBlank(param) && StringUtils.isNotBlank(otherHql)
				&& arrayList.size() > 1) {
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			// 防止添加sql前面没有空格
			hql.append(" ");
			hql.append(otherHql);
			values.put(param, value);
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}
	
	/**
	 * 
	 *  根据机构编码右模糊匹配</br>
	 *  @param column 字段
	 *  @param orgCode 从后往前截取不为0的dm
	 *  @param arrayList arrayList
	 *  @return arrayList
	 *  @author llchen@iflytek.com
	 *  @created 2015-2-9 下午07:28:57
	 *  @lastModified
	 *  @history
	 */
	public static ArrayList hqlOrgCodeRLike(String column,String orgCode,ArrayList<Object> arrayList){
		if(StringUtils.isNotBlank(orgCode)){
			orgCode = orgCode.replaceAll("0*$", StringUtils.EMPTY);
			StringBuilder hql = (StringBuilder) arrayList.get(0);
			Map<String, Object> values = (Map<String, Object>) arrayList.get(1);
			hql.append(" and ").append(column).append(" like :").append(
					column.replaceAll("\\.", ""));
			values.put(column.replaceAll("\\.", ""), orgCode + SPLIT_FLAG_BFH);
			arrayList.add(0, hql);
			arrayList.add(1, values);
		}
		return arrayList;
	}
	

}
