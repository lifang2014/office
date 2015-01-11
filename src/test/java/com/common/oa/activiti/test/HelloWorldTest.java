package com.common.oa.activiti.test;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

/**
 * 学习Activiti demo 01
 * Created by Jerry on 2014/11/27.
 */
public class HelloWorldTest {

    private Logger logger = LoggerFactory.getLogger(HelloWorldTest.class);

    private ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 部署流程定义
     */
    @Test
    public void testDeploymentProcessDefinition(){
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .name("hello-world")
                .addClasspathResource("activiti/helloworld.bpmn")
                .addClasspathResource("activiti/helloworld.png")
                .deploy();
        logger.info("部署ID : {}",deployment.getId());
        logger.info("部署名称: {}", deployment.getName());
    }

    @Test
    public void testDeploymentProcessDefinitionZip(){
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("activiti/helloword.zip");
        ZipInputStream zin = new ZipInputStream(in);
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .name("hello-world-zip")
                .addZipInputStream(zin)
                .deploy();
        logger.info("部署ID : {}",deployment.getId());
        logger.info("部署名称: {}", deployment.getName());
    }


    /**
     * 驱动流程实例
     */
    @Test
    public void testStartProcessInstance(){
        String processKey = "helloworld";
        ProcessInstance processInstance = processEngine.getRuntimeService()
                .startProcessInstanceByKey(processKey);
        logger.info("流程实例ID : {}", processInstance.getId());
        logger.info("流程定义ID : {}", processInstance.getProcessDefinitionId());
    }


    /**
     * 查询当前任务
     */
    @Test
    public void testFindCurrentTask(){
        String assignee = "zhansan";
        List<Task> lstTask = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee(assignee)
                .list();
        for(Task task : lstTask){
            logger.info("任务ID:{}",task.getId());
            logger.info("任务名称:{}", task.getName());
            logger.info("任务创建时间:{}", task.getCreateTime());
            logger.info("任务办理人:{}", task.getAssignee());
            logger.info("执行对象ID:{}", task.getExecutionId());
            logger.info("流程实例ID:{}",task.getProcessInstanceId());
            logger.info("流程定义ID:{}",task.getProcessDefinitionId());
        }
    }

    /**
     * 完成任务
     */
    @Test
    public void testCompleteTask(){
        String taskId = "104";
        processEngine.getTaskService().complete(taskId);
        logger.info("完成任务，ID ：{}", taskId );
    }
}
