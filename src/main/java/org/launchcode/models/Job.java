package org.launchcode.models;

/**
 * Created by LaunchCode
 */
public class Job {

    private int id;
    private static int nextId = 1;

    public String name;
    public Employer employer;
    public Location location;
    public PositionType positionType;
    public CoreCompetency coreCompetency;
    public Job request;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation,
               PositionType aPositionType, CoreCompetency aSkill) {

        this();

        name = aName;
        employer = aEmployer;
        location = aLocation;
        positionType = aPositionType;
        coreCompetency = aSkill;

    }

    public String getName(String name) {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer(String employer) {
        return this.employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation(String location) {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType(String positionType) {
        return this.positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency(String coreCompetency) {
        return this.coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        return id == job.id;
    }

    @Override
    public int hashCode() {
        return id;
    }


}
