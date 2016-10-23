package com.mycompany.app.concurrency;

public class ThreadInfo {

    public static void main(String[] args) {
        new ThreadInfoDisplayer(Thread.currentThread()).displayThreadInfos();
    }

    static class ThreadInfoDisplayer {
        private Thread thread;

        public ThreadInfoDisplayer(Thread thread) {
            this.thread = thread;
        }

        public void displayThreadInfos() {
            displayElement("Name", String.valueOf(thread.getName()));
            displayElement("Priority", String.valueOf(thread.getPriority()));
            displayElement("ContextClassLoader", String.valueOf(thread.getContextClassLoader()));
            displayElement("StackTrace", String.valueOf(thread.getStackTrace()));
            displayElement("State", String.valueOf(thread.getState()));
            displayElement("ThreadGroup", String.valueOf(thread.getThreadGroup()));
        }

        private void displayElement(String label, String value) {
            System.out.println(String.format("%s: %s", label, value));
        }
    }
}
