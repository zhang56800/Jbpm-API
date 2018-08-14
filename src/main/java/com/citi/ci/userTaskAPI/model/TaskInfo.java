/**
 * 
 */
package com.citi.ci.userTaskAPI.model;

import org.kie.api.task.model.TaskData;

/**
 * @author alen
 * 2018年8月9日下午4:33:48
 */
public class TaskInfo {
	
	private Long taskID;
	private Long ProcessID;
	private TaskData taskData;
	/**
	 * @return the taskID
	 */
	public Long getTaskID() {
		return taskID;
	}
	/**
	 * @param taskID the taskID to set
	 */
	public void setTaskID(Long taskID) {
		this.taskID = taskID;
	}
	/**
	 * @return the processID
	 */
	public Long getProcessID() {
		return ProcessID;
	}
	/**
	 * @param processID the processID to set
	 */
	public void setProcessID(Long processID) {
		ProcessID = processID;
	}
	/**
	 * @return the taskData
	 */
	public TaskData getTaskData() {
		return taskData;
	}
	/**
	 * @param taskData the taskData to set
	 */
	public void setTaskData(TaskData taskData) {
		this.taskData = taskData;
	}

}
