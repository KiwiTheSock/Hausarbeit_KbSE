/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.osca.mp.entity;

import de.hsos.kbse.osca.mp.abstracts.AbstractEntity;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Philipp
 */
@Entity
public class Exam extends AbstractEntity {
    
    @NotNull(message = "duration can't be empty")
    private float duration;
    @NotNull(message = "Starttime can't be empty")
    private Time start;
    @NotNull(message = "Endtime can't be empty")
    private Time end;
    @NotNull(message = "Amount can't be empty")
    private int spaceforStudents;
    @NotNull(message = "Day can't be empty")
    private Date day;
    
    @ManyToOne
    private List<Module> modules;
    
    @OneToMany
    private List<TimeSlot> timeslots;

    public Exam() {
    }

    public Exam(float duration, Time start, Time end, int spaceforStudents, Date day, List<Module> modules, List<TimeSlot> timeslots) {
        this.duration = duration;
        this.start = start;
        this.end = end;
        this.spaceforStudents = spaceforStudents;
        this.day = day;
        this.modules = modules;
        this.timeslots = timeslots;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public Time getStart() {
        return start;
    }

    public void setStart(Time start) {
        this.start = start;
    }

    public Time getEnd() {
        return end;
    }

    public void setEnd(Time end) {
        this.end = end;
    }

    public int getSpaceforStudents() {
        return spaceforStudents;
    }

    public void setSpaceforStudents(int spaceforStudents) {
        this.spaceforStudents = spaceforStudents;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<TimeSlot> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(List<TimeSlot> timeslots) {
        this.timeslots = timeslots;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Float.floatToIntBits(this.duration);
        hash = 43 * hash + Objects.hashCode(this.start);
        hash = 43 * hash + Objects.hashCode(this.end);
        hash = 43 * hash + this.spaceforStudents;
        hash = 43 * hash + Objects.hashCode(this.day);
        hash = 43 * hash + Objects.hashCode(this.modules);
        hash = 43 * hash + Objects.hashCode(this.timeslots);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Exam other = (Exam) obj;
        if (Float.floatToIntBits(this.duration) != Float.floatToIntBits(other.duration)) {
            return false;
        }
        if (this.spaceforStudents != other.spaceforStudents) {
            return false;
        }
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        if (!Objects.equals(this.end, other.end)) {
            return false;
        }
        if (!Objects.equals(this.day, other.day)) {
            return false;
        }
        if (!Objects.equals(this.modules, other.modules)) {
            return false;
        }
        if (!Objects.equals(this.timeslots, other.timeslots)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Exam{" + "duration=" + duration + ", start=" + start + ", end=" + end + ", spaceforStudents=" + spaceforStudents + ", day=" + day + ", modules=" + modules + ", timeslots=" + timeslots + '}';
    }
}
