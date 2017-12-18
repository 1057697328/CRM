package cn.hang.crm.modules.act.service.impl;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author lihang
 * @create 2017-11-28 下午7:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring.xml"})
public class TestActiviti {
    @Autowired
    private ProcessEngine processEngine;

    @Test
    public void createTable() {
        ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
        processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
        processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/crm?useUnicode=true&characterEncoding=utf8");
        processEngineConfiguration.setJdbcUsername("root");
        processEngineConfiguration.setJdbcPassword("123456");

        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        System.out.println(processEngine);
    }

    @Test
    public void DeploymentProcessDefinition() {
        Deployment deployment = processEngine.getRepositoryService().createDeployment()
                .name("hello")
                .addClasspathResource("leave.bpmn")
                .deploy();
        System.out.println("部署实例id:" + deployment.getId());
        System.out.println("部署实例name:" + deployment.getName());
    }

    @Test
    public void startProcessInstance() {
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("helloworld");
        System.out.println("流程实例id:" + processInstance.getId());
        System.out.println("流程定义id:" + processInstance.getProcessDefinitionId());
    }

    @Test
    public void findMyTask() {
        List<Task> list = processEngine.getTaskService().createTaskQuery().taskAssignee("张三").list();
        if (list != null && list.size() > 0) {
            for (Task task : list) {
                System.out.println(task.getAssignee());
                System.out.println(task.getCreateTime());
                System.out.println(task.getName());
                System.out.println(task.getProcessInstanceId());//流程实例id
                System.out.println(task.getExecutionId());
            }
        }
    }

    @Test
    public void completeMyTask() {
        processEngine.getTaskService().complete("2504");
    }

    @Test
    public void viewPic() throws IOException {
        String picName = "";
        List<String> list = processEngine.getRepositoryService().getDeploymentResourceNames("1");
        for (String s : list) {
            if (s.contains("png")) {
                picName = s;
            }
        }
        InputStream inputStream = processEngine.getRepositoryService().getResourceAsStream("1", picName);
        File file = new File("/Users/lihang/" + picName);
        FileUtils.copyInputStreamToFile(inputStream, file);
    }

}
