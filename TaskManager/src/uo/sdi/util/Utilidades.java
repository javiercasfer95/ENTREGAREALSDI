package uo.sdi.util;

import uo.sdi.dto.Task;

public class Utilidades {

	public final static Task clonarTarea(Task oldTask){
		Task cloneTask = new Task();
		
		cloneTask.setCategoryId(oldTask.getCategoryId());
		cloneTask.setComments(oldTask.getComments());
		cloneTask.setCreated(oldTask.getCreated());
		cloneTask.setFinished(oldTask.getFinished());
		cloneTask.setId(oldTask.getId());
		cloneTask.setPlanned(oldTask.getPlanned());
		cloneTask.setTitle(oldTask.getTitle());
		cloneTask.setUserId(oldTask.getUserId());
		
		return cloneTask;
	}
}
