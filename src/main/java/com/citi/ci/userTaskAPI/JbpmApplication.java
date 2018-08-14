/**
 * 
 */
package com.citi.ci.userTaskAPI;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.manager.RuntimeEngine;
import org.kie.api.runtime.manager.RuntimeManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citi.ci.userTaskAPI.util.RunTime;



/**
 * @author alen
 * 2018年8月2日下午12:23:19
 */
@RestController
@SpringBootApplication
@EnableAutoConfiguration
public class JbpmApplication {
	private static KieServices ks;
	private static KieContainer kContainer;
	private static KieBase kbase;
	private static RuntimeManager manager;
	private static RuntimeEngine engine;
	private static KieSession ksession;
	
	
	/**
	 * @return the ksession
	 */
	public static KieSession getKsession() {
		return ksession;
	}

	/**
	 * @param ksession the ksession to set
	 */
	public static void setKsession(KieSession ksession) {
		JbpmApplication.ksession = ksession;
	}
	public static void KieServerInitial() {
		ks = KieServices.Factory.get();
		kContainer = ks.getKieClasspathContainer();
		kbase = kContainer.getKieBase("kbase");
		manager = RunTime.createRuntimeManager(kbase);
		engine = manager.getRuntimeEngine(null);
		JbpmApplication.setKsession(engine.getKieSession());
		JbpmApplication.setEngine(engine);
		System.out.println("KieServer Start");
		
	}

	public static void main(String[] args) {
        SpringApplication.run(JbpmApplication.class, args);
        JbpmApplication.KieServerInitial();
    }
	
	/**
	 * @return the engine
	 */
	public static RuntimeEngine getEngine() {
		return engine;
	}

	/**
	 * @param engine the engine to set
	 */
	public static void setEngine(RuntimeEngine engine) {
		JbpmApplication.engine = engine;
	}

	@RequestMapping("/")
	String hello() {
		return"Hello Spring Test";
	}

}
