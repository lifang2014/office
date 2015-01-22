package com.common.oa.activiti.test;

import junit.framework.Assert;
import org.activiti.engine.*;
import org.activiti.engine.identity.User;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lifang on 2015/1/13.
 */
public class ActivitiDemo01 {

    private Logger logger = LoggerFactory.getLogger(ActivitiDemo01.class);

    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    @Test
    public void testDisplayProcessDemo(){

        //创建流程实例，使用内存数据库
//        ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration().buildProcessEngine();

        //使用配置文件连接MySQL
//        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

        //部署流程定义文件
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("activiti/leave.bpmn").deploy();

        //验证布署流程,
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().singleResult();
        System.out.println("processKey:" + processDefinition.getKey());

        //启动流程,并返回流程实例
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess");

        Assert.assertNotNull(processEngine);

        System.out.println("process instance id : " + processInstance.getId());
        System.out.println("process instance pdid : " + processInstance.getProcessDefinitionId());
    }


    @Test
    public void testDispalyDemo02(){

        //部署流程
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("activiti/leave20.bpmn").deploy();

        //获取流程定义
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().singleResult();

        logger.info("process definition key : {}", processDefinition.getKey());
        logger.info("process definition id : {}", processDefinition.getId());
        logger.info("process definition name : {}", processDefinition.getName());

        //启动流程，并返回流程实例
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("myProcess_1");

        Assert.assertNotNull(processInstance);

        logger.info("process instance id : {}", processInstance.getId());
        logger.info("process instance name:{}", processInstance.getName());
        logger.info("process instance pdid:{}", processInstance.getProcessDefinitionId());
    }


    @Test
    public void testDispalyDemo03(){

        //部署流程
        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("activiti/leave21.bpmn").deploy();

        //获取流程实例
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().singleResult();

        logger.info("process definition key:{}", processDefinition.getKey());

        //启动流程
        RuntimeService runtimeService = processEngine.getRuntimeService();
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("applyUser", "employee1");
        variables.put("day", 3);
        runtimeService.startProcessInstanceByKey(processDefinition.getKey(), variables);

        //查询任务
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery().taskCandidateGroup("deptLeader").singleResult();

        logger.info("current task name : {}", task.getName());

        //任务签收
        taskService.claim(task.getId(), "leaderUser");
        variables.put("approved", true);

        //完成任务
        taskService.complete(task.getId(), variables);

        task = taskService.createTaskQuery().taskCandidateGroup("deptLeader").singleResult();

//        Assert.assertNotNull(task);

        //查询已完成任务数量
        HistoryService historyService = processEngine.getHistoryService();

        long count = historyService.createHistoricProcessInstanceQuery().finished().count();

        logger.info("history task count : {}", count);
    }


    @Test
    public void testAddUser(){

        ActivitiRule activitiRule = new ActivitiRule();

        IdentityService identityService = activitiRule.getIdentityService();

        User user = identityService.newUser("jerry");
        user.setFirstName("li");
        user.setLastName("fang");
        user.setEmail("jetty@qq.com");
        identityService.saveUser(user);

        User u = identityService.createUserQuery().userId("jerry").singleResult();

        logger.info("db is user : " + u);

        identityService.deleteUser("jerry");

        u = identityService.createUserQuery().userId("jerry").singleResult();

        org.junit.Assert.assertNotNull("the db user is null", u);

    }


    @Test
    public void testDesplayProcess(){

        RepositoryService repositoryService = processEngine.getRepositoryService();
        repositoryService.createDeployment().addClasspathResource("activiti/leave22.bpmn").deploy();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().singleResult();

        logger.info("process definition key:{}", processDefinition.getKey());

    }

}
