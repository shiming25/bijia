package com.sou.common.util;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mchange.v2.c3p0.PooledDataSource;
//import com.tuniu.aladdin.common.util.SpringContextHelper;

/**
 * 数据库连接池相关
 * 
 * @author shiming
 * 
 */
public class DataSourceUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(DataSourceUtil.class);
	
	/**
	 * 获取连接池使用情况
	 */
	public static  void getDataSourceInfo() {
		Thread t = new Thread() {
			public void run() {
//				try {
//					PooledDataSource ds = (PooledDataSource) SpringContextHelper.getBean("orderDataSource");
//					StringBuffer dsSb = new StringBuffer();
//					dsSb.append("=====连接池使用情况=====\r\n")
//							.append("已用数getNumBusyConnectionsDefaultUser:" + ds.getNumBusyConnectionsDefaultUser())
//							.append("\r\n可用数getNumIdleConnectionsDefaultUser:" + ds.getNumIdleConnectionsDefaultUser())
//							.append("\r\n总数getNumIdleConnectionsDefaultUser:" + ds.getNumConnectionsDefaultUser())
//							.append("\r\ngetNumThreadsAwaitingCheckoutDefaultUser:"
//									+ ds.getNumThreadsAwaitingCheckoutDefaultUser())
//							.append("\r\ngetNumUnclosedOrphanedConnectionsDefaultUser:"
//									+ ds.getNumUnclosedOrphanedConnectionsDefaultUser());
//
//					LOG.info(dsSb.toString());

					/**
					 * LOG.info("已用数getNumBusyConnectionsDefaultUser:" +
					 * ds.getNumBusyConnectionsDefaultUser());
					 * LOG.info("可用数getNumIdleConnectionsDefaultUser:" +
					 * ds.getNumIdleConnectionsDefaultUser()); LOG.info(
					 * "getNumUnclosedOrphanedConnectionsDefaultUser:" +
					 * ds.getNumUnclosedOrphanedConnectionsDefaultUser());
					 * LOG.info("getStatementCacheNumStatementsDefaultUser:" +
					 * ds.getStatementCacheNumStatementsDefaultUser());
					 * LOG.info("getStatementCacheNumCheckedOutDefaultUser:" +
					 * ds.getStatementCacheNumCheckedOutDefaultUser());
					 * LOG.info(
					 * "getStatementCacheNumConnectionsWithCachedStatementsDefaultUser:"
					 * + ds.
					 * getStatementCacheNumConnectionsWithCachedStatementsDefaultUser
					 * ()); LOG.info("getStartTimeMillisDefaultUser:" +
					 * ds.getStartTimeMillisDefaultUser());
					 * LOG.info("getUpTimeMillisDefaultUser:" +
					 * ds.getUpTimeMillisDefaultUser());
					 * LOG.info("getNumFailedCheckinsDefaultUser:" +
					 * ds.getNumFailedCheckinsDefaultUser());
					 * LOG.info("getNumFailedCheckoutsDefaultUser:" +
					 * ds.getNumFailedCheckoutsDefaultUser());
					 * LOG.info("getNumFailedIdleTestsDefaultUser:" +
					 * ds.getNumFailedIdleTestsDefaultUser());
					 * LOG.info("getEffectivePropertyCycleDefaultUser:" +
					 * ds.getEffectivePropertyCycleDefaultUser());
					 * LOG.info("getNumThreadsAwaitingCheckoutDefaultUser:" +
					 * ds.getNumThreadsAwaitingCheckoutDefaultUser());
					 * LOG.info("sampleThreadPoolStackTraces:" +
					 * ds.sampleThreadPoolStackTraces());
					 * LOG.info("sampleThreadPoolStatus:" +
					 * ds.sampleThreadPoolStatus());
					 * LOG.info("sampleStatementCacheStatusDefaultUser:" +
					 * ds.sampleStatementCacheStatusDefaultUser());
					 * LOG.info("getLastAcquisitionFailureDefaultUser:" +
					 * ds.getLastAcquisitionFailureDefaultUser());
					 * LOG.info("getLastCheckinFailureDefaultUser:" +
					 * ds.getLastCheckinFailureDefaultUser());
					 * LOG.info("getLastCheckoutFailureDefaultUser:" +
					 * ds.getLastCheckoutFailureDefaultUser());
					 * LOG.info("getLastIdleTestFailureDefaultUser:" +
					 * ds.getLastIdleTestFailureDefaultUser());
					 * LOG.info("getLastConnectionTestFailureDefaultUser:" +
					 * ds.getLastConnectionTestFailureDefaultUser());
					 * 
					 * LOG.info(
					 * "sampleLastAcquisitionFailureStackTraceDefaultUser:" +
					 * ds.sampleLastAcquisitionFailureStackTraceDefaultUser());
					 * LOG.info("sampleLastCheckinFailureStackTraceDefaultUser:"
					 * + ds.sampleLastCheckinFailureStackTraceDefaultUser());
					 * LOG
					 * .info("sampleLastCheckoutFailureStackTraceDefaultUser:" +
					 * ds.sampleLastCheckoutFailureStackTraceDefaultUser());
					 * LOG.
					 * info("sampleLastIdleTestFailureStackTraceDefaultUser:" +
					 * ds.sampleLastIdleTestFailureStackTraceDefaultUser());
					 * LOG.info(
					 * "sampleLastConnectionTestFailureStackTraceDefaultUser:" +
					 * ds
					 * .sampleLastConnectionTestFailureStackTraceDefaultUser());
					 * 
					 * LOG.info("getNumUserPools:" + ds.getNumUserPools());
					 * LOG.info("getNumHelperThreads:" +
					 * ds.getNumHelperThreads()); LOG.info("getAllUsers:" +
					 * ds.getAllUsers());
					 **/
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		};
		t.start();
	}
}
