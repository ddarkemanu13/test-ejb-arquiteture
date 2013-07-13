import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.business.teste.app.App;


@ManagedBean(name = "objectsSimulatorController")
@SessionScoped
public class ObjectsSimulatorController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long time;
	
	public void smallList() {
		populateList(10, 1);
	}
	
	public void largeList() {
		populateList(100000, 100);
	}
	
	private void populateList(int numberOfObjects, int numberOfFiles) {
		this.time = System.currentTimeMillis();
		for(int i=0; i <= numberOfFiles; i++) {
			File file = new File("file"+i+".txt");
		    FileWriter writer = null;
		    try {
		    	writer = new FileWriter(file);
		        for(int j=0; j <= numberOfObjects; j++)  {
		        	 writer.write(new App(Long.valueOf(i), "description "+i).toString());
		        }
		    } catch (IOException e) {
		        e.printStackTrace(); 
		    } finally {
		        if (writer != null) try { writer.close(); } catch (IOException ignore) {}
		    }
		    System.out.printf("File is located at %s%n", file.getAbsolutePath());
		}
		
		this.time = (System.currentTimeMillis() - this.time);
	}
	
	public long getTime() {
		return time;
	}
}
