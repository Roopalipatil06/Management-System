package Management_System;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
	public class Process_Manager {
	    private ArrayList<Process> processes;
	    private LinkedList<Process> pendingHistory;
	    private LinkedList<Process> completedHistory;
            public Process_Manager() {
	        processes = new ArrayList<>();
	        pendingHistory = new LinkedList<>();
	        completedHistory = new LinkedList<>();
	    }
            //  Add Process
	    public void addProcess(Process process) {
	        processes.add(process);
	        if (process.getStatus().equals(Process.PENDING)) {
	            addPendingProcess(process);
	        } else if (process.getStatus().equals(Process.COMPLETED)) {
	            addCompletedProcess(process);
	        }
	    }
               //Remove Process
	    public boolean removeProcess(int processId) {
	        for (Process process : processes) {
	            if (process.getProcessId() == processId) {
	                processes.remove(process);
	                return true;
	            }
	        }
	        return false;
	    }
          //Search for a Process
	    public Process searchProcess(int processId) {
	        for (Process process : processes) {
	            if (process.getProcessId() == processId) {
	                return process;
	            }
	        }
	        return null;
	    }
          // List All Processes
	    public List<Process> listAllProcesses() {
	        return new ArrayList<>(processes);
	    }
          //Update Process Status
	    public boolean updateProcessStatus(int processId, String newStatus) {
	        for (Process process : processes) {
	            if (process.getProcessId() == processId) {
	                process.setStatus(newStatus);
	                if (newStatus.equals(Process.PENDING)) {
	                    addPendingProcess(process);
	                } else if (newStatus.equals(Process.COMPLETED)) {
	                    addCompletedProcess(process);
	                }
	                return true;
	            }
	        }
	        return false;
	    }
        // Pending and Completed Process History
	    public void addPendingProcess(Process process) {
	        pendingHistory.add(process);
	    }

	    public void addCompletedProcess(Process process) {
	        completedHistory.add(process);
	    }

	    public List<Process> getPendingProcessesHistory() {
	        return new LinkedList<>(pendingHistory);
	    }

	    public List<Process> getCompletedProcessesHistory() {
	        return new LinkedList<>(completedHistory);
	    }

	    public static void main(String[] args) {
	        Process_Manager processManager = new Process_Manager();

	        // Creating processes
	        Process process1 = new Process(1,"Project AB", "Pending");
	        Process process2 = new Process(2, "Reporting", Process.RUNNING);
	        Process process3 = new Process(3, "Cloning", Process.COMPLETED);

	        // Adding processes
	        processManager.addProcess(process1);
	        processManager.addProcess(process2);
	        processManager.addProcess(process3);

	        // Listing all processes
	        System.out.println("All Processes:");
	        for (Process process : processManager.listAllProcesses()) {
	            System.out.println(process);
	        }

	        // Searching for a process
	        System.out.println("Search Process with ID 1:");
	        System.out.println(processManager.searchProcess(1));

	        // Updating process status
	        System.out.println("Updating Process 2 status to Completed:");
	        processManager.updateProcessStatus(2, Process.COMPLETED);
	        System.out.println(processManager.searchProcess(2));

	        // Removing a process
	        System.out.println("Removing Process with ID 1:");
	        processManager.removeProcess(1);
	        for (Process process : processManager.listAllProcesses()) 
	        {
	            System.out.println(process);
	        }

	        // pending history
	        System.out.println("Pending Processes History:");
	        for (Process process : processManager.getPendingProcessesHistory())
	        {
	            System.out.println(process);
	        }

	        // completed history
	        System.out.println("Completed Processes History:");
	        for (Process process : processManager.getCompletedProcessesHistory()) 
	        {
	            System.out.println(process);
	        }
	    }
	}
