import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


@ManagedBean(name = "log4jController" )
@RequestScoped
public class Log4jController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 protected final Logger logger = LogManager.getLogger(Log4jController.class.getName());
	 
	 private long timeToLog;

	 public void loggerConsole() {
		 long initTime = System.currentTimeMillis();
		 logger.info("TESTEEEEE");
		 logger.error("Sample debug message");
		 this.timeToLog = (System.currentTimeMillis() - initTime);
	 }
	 
	 public long getTimeToLog() {
		return timeToLog;
	}
}
