package edu.virginia.cs.sde.efficiency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void getX() {
        Point p = new Point(3.0, 5.0);
        assertEquals(3, p.getX(), 1e-14);
    }

    @Test
    void setX() {
        Point p = new Point(3.0, 5.0);
        p.setX(4);
        assertEquals(4, p.getX(), 1e-14);
    }

    @Test
    void getY() {
        Point p = new Point(3.0, 5.0);
        assertEquals(5, p.getY(), 1e-14);
    }

    @Test
    void setY() {
        Point p = new Point(3.0, 5.0);
        p.setY(7.0);
        assertEquals(7, p.getY(), 1e-14);
    }

    @Test
    void distance() {
        Point a = new Point(1.0, 2.0);
        Point b = new Point(4.0, 6.0);
        assertEquals(5.0, a.distanceTo(b), 1e-14);
    }

    @Test
    void testEquals_notEqual() {
        Point a = new Point(1.0, 2.0);
        Point b = new Point(4.0, 6.0);
        assertNotEquals(a, b);
    }

    @Test
    void testEquals_Equal() {
        Point a = new Point(1.0, 2.0);
        Point b = new Point(a);
        assertEquals(a, b);
    }
}