/**
 * 
 */
package com.citi.ci.userTaskAPI.controller;


import java.util.List;

import org.jbpm.services.task.impl.model.UserImpl;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.task.TaskService;
import org.kie.api.task.model.Task;
import org.kie.api.task.model.TaskData;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citi.ci.userTaskAPI.JbpmApplication;
import com.citi.ci.userTaskAPI.model.TaskInfo;
import com.citi.ci.userTaskAPI.model.TaskResponse;

import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;


/**
 * @author alen
 * 2018年8月2日上午10:41:52
 */
@Controller
@RequestMapping(value = "bpm/case")
public class ProcessController {

	private TaskService taskService ;
	private Task task;
	private TaskData taskData;
	private JSONObject jObject = new JSONObject();
	private TaskResponse taskResponse = new TaskResponse();
	private String username;
	private String taskStatus;
	private TaskInfo taskInfo = new TaskInfo();
	
	
	@RequestMapping(value="caseStart",method = RequestMethod.GET)
	@ApiOperation(value="start")
	@ResponseBody
	public String  caseStart() {
		KieSession ksession=JbpmApplication.getKsession();
		
		ProcessInstance processInstance=ksession.startProcess("com.citi.ci.userTaskFlow");
//		String PName=processInstance.getProcessName();
		Long Id=processInstance.getId();
//		String PId = processInstance.getProcessId(); process ID
		taskService =JbpmApplication.getEngine().getTaskService();
		List<Long> taskIDs=taskService.getTasksByProcessInstanceId(Id);
		taskInfo.setProcessID(Id);
		taskInfo.setTaskID(taskIDs.get(0));
//		Collection<ProcessInstance> processInstances=ksession.getProcessInstances();
//		for (ProcessInstance processInstance2 : processInstances) {
//			System.out.println("current processinstances id:"+processInstance2.getId());
//		}
//		for (Long long1 : taskIDs) {
//			System.out.println("current taskid in this process instance"+long1);
//		}
		
		jObject.put("caseID", Id);
		System.out.println("Start Successed"+" current processinstances id: "+Id+"current taskid in this process instance: "+taskIDs.toString());
		return jObject.toString();
		
	}
	@RequestMapping(value="{caseID}/lock"
			+ "",method = RequestMethod.GET)
	@ApiOperation(value="startTaskByTaskId")
	@ResponseBody
	public TaskResponse startTaskById(@PathVariable Long caseID) {
		System.out.println(caseID);
		/*list = taskService.getTasksAssignedAsPotentialOwner(username, "en-UK");
		for (TaskSummary taskSummary : list) {
			String taskName = taskSummary.getName();
			System.out.println(taskName);
		}
		TaskSummary task = list.get(0);
		String taskName = task.getName();*/
		taskService = JbpmApplication.getEngine().getTaskService();
		
		
//		username = getTaskNameByID(caseID);

		taskService.start(caseID, "john");
		taskStatus=getTaskStatusByID(caseID);
		taskResponse.setStatus(taskStatus);
		System.out.println("taskStatus: "+taskStatus);
		
		return taskResponse;
	}
	
	
	@RequestMapping(value="{caseID}/release",method = RequestMethod.GET)
	@ApiOperation(value="runTaskByTaskId")
	@ResponseBody
	public TaskResponse runTaskById(@PathVariable Long caseID) {
		System.out.println(caseID);
		/*list = taskService.getTasksAssignedAsPotentialOwner(username, "en-UK");
		for (TaskSummary taskSummary : list) {
			String taskName = taskSummary.getName();
			System.out.println(taskName);
		}
		TaskSummary task = list.get(0);
		String taskName = task.getName();*/
		/*Task task = taskService.getTaskById(taskId);
		TaskData taskData=task.getTaskData();
		String username=taskData.getActualOwner().getId();*/
		taskService =JbpmApplication.getEngine().getTaskService();
//		Task task = taskService.getTaskById(taskId);
		username = getTaskNameByID(caseID);
		taskService.complete(caseID, username,null);
		taskStatus = getTaskStatusByID(caseID);
		taskResponse.setStatus(taskStatus);
		System.out.println("next task ID : "+ getCurrentTaskID(taskInfo));	
		System.out.println(taskStatus);		
		return taskResponse;
	}
	
	private String getTaskNameByID(long taskId) {
		task = taskService.getTaskById(taskId);
		taskData=task.getTaskData();
		String username=taskData.getActualOwner().getId();
		String taskStatus=taskData.getStatus().toString();
		System.out.println("taskStatus: "+taskStatus);
		return username;
		
	}
	
	private String getTaskStatusByID(long taskId) {
		task = taskService.getTaskById(taskId);
		taskData=task.getTaskData();
		taskStatus=taskData.getStatus().toString();
		System.out.println("taskStatus: "+taskStatus);
		
		return taskStatus;
		
	}
	
	
	public Long getCurrentTaskID (TaskInfo taskInfo) {
		List<Long> taskIDs=taskService.getTasksByProcessInstanceId(taskInfo.getProcessID());
		System.out.println(taskIDs.toString());
		return taskIDs.get(1);
	}
	
}
 