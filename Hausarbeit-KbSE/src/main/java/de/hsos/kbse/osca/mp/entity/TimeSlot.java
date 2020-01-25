/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.osca.mp.entity;

import de.hsos.kbse.osca.mp.abstracts.AbstractEntity;
import java.sql.Time;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Philipp
 */
@Entity
public class TimeSlot extends AbstractEntity {

    private float slot;

    @ManyToOne
    private List<Exam> exam;

    public TimeSlot() {
    }

    public TimeSlot(float slot, List<Exam> exam) {
        this.slot = slot;
        this.exam = exam;
    }

    public float getSlot() {
        return slot;
    }

    public void setSlot(float slot) {
        this.slot = slot;
    }

    public List<Exam> getExam() {
        return exam;
    }

    public void setExam(List<Exam> exam) {
        this.exam = exam;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Float.floatToIntBits(this.slot);
        hash = 43 * hash + Objects.hashCode(this.exam);
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
        final TimeSlot other = (TimeSlot) obj;
        if (Float.floatToIntBits(this.slot) != Float.floatToIntBits(other.slot)) {
            return false;
        }
        if (!Objects.equals(this.exam, other.exam)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TimeSlot{" + "slot=" + slot + ", exam=" + exam + '}';
    }
}
