package tw.leonchen.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("wDao")
public class WorkerDao {

	@Autowired	@Qualifier("worker1")
	private Worker worker;

	
//	public WorkerDao() {
//	}
//	@Autowired
//	public WorkerDao(@Qualifier("worker1") Worker worker) {
//		this.worker = worker;
//	}
//	
//
//	public void setWorker(Worker worker) {
//		this.worker = worker;
//	}
	public void printDetails() {
		System.out.println("ID:" + worker.getId());
		System.out.println("Nane:" + worker.getName());
		System.out.println("Title:" + worker.getTitle());

	}

}
