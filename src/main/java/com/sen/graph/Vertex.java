package com.sen.graph;

/**
 * @Auther: Sen
 * @Date: 2019/10/22 00:09
 * @Description: 顶点
 */
public class Vertex {

    private String value;

    /**
     * false未访问，true已访问
     */
    private boolean visited;

    public Vertex() {
    }

    public Vertex(String value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "value='" + value + '\'' +
                '}';
    }
}
