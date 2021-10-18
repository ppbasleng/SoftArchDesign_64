package edu.parinya.softarchdesign.structural;

public abstract class HealthcareWorkerDecorator extends HealthcareWorker {
    protected HealthcareServiceable worker;

    HealthcareWorkerDecorator(HealthcareWorker worker) { 
        super(worker);
        this.worker = worker;
    }

    public void service(){
        worker.service();
    }
    public double getPrice(){
        return worker.getPrice();
    }
}
