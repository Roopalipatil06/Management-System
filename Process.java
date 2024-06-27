package Management_System;
public class Process {
    private int processId;
    private String processName;
    private String status;
     public static final String PENDING = "Pending";
     public static final String RUNNING = "Running";
     public static final String COMPLETED = "Completed"; //final because pending,running,completed are constat value

    public Process(int processId, String processName, String status) { // use constructor
        this.processId = processId;
        this.processName = processName;
        setStatus(status); // set status method use to chekc the status is valid
    }
     public int getProcessId() { // use getter method to return process Id
        return processId;
    }
       public String getProcessName() {  // to return process name
        return processName;
    }
      public String getStatus() {    // to return process status
        return status;
    }
     public void setStatus(String status) {  // set for status process
        if (status.equals(PENDING) || status.equals(RUNNING) || status.equals(COMPLETED)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException("Invalid status: " + status);
        }   // throw exception if status is invalid
    }
    @Override
    public String toString() {
        return "Process{" +"processId=" + processId +", processName='" + processName + '\'' +", status='" + status + '\'' +
                '}';
    }
        public static void main(String[] args) {
        // Test the Process class
        Process process1 = new Process(1, "Sample Process 1", PENDING);
        System.out.println(process1);

        process1.setStatus(RUNNING);
        System.out.println(process1);

        try {
            process1.setStatus("InvalidStatus");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
