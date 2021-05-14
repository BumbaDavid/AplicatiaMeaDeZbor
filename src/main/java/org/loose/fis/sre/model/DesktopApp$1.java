package org.loose.fis.sre.model;

class DesktopApp$1 implements Runnable {
    DesktopApp$1() {
    }

    public void run() {
        try {
            DesktopApp window = new DesktopApp();
            window.frame.setVisible(true);
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }
}