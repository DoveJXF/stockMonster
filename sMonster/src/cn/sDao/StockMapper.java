package cn.sDao;

import org.apache.ibatis.annotations.Param;

public interface StockMapper {

	int VERSIONSTATUS_UNREADY = 0;
	int VERSIONSTATUS_READY = 1;
	Integer[] ARR_VERSIONSTATUS = { VERSIONSTATUS_READY, VERSIONSTATUS_UNREADY };

	int DELFLAG_NORMAL = 0;
	int DELFLAG_RECYCLE = 1;
	int DELFLAG_DELETED = 2;

	/**
	 * 通过调用数据库的存储过程，删除指定对象的所有相关记录。 注：除了最后的删除任务
	 * 
	 * @param moid
	 * @return
	 */
	String selectAllBySid(@Param("sid") String sid);
}
