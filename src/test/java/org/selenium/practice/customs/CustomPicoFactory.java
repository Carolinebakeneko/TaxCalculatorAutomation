package org.selenium.practice.customs;

import io.cucumber.core.backend.ObjectFactory;
import io.cucumber.picocontainer.PicoFactory;
import org.selenium.practice.controllers.ChromeController;
import org.selenium.practice.controllers.SauceLabsController;
import org.selenium.practice.pages.LoginPageImpl;

public class CustomPicoFactory implements ObjectFactory {
    private PicoFactory delegate = new PicoFactory();
    public CustomPicoFactory(){
setDriver();
addClass(LoginPageImpl.class);
    }
    @Override
    public void start() {
delegate.start();
    }

    @Override
    public void stop() {
delegate.stop();
    }

    @Override
    public boolean addClass(Class<?> aClass) {
        return delegate.addClass(aClass);
    }

    @Override
    public <T> T getInstance(Class<T> aClass) {
        return delegate.getInstance(aClass);
    }
    private void setDriver()
    {

        addClass(SauceLabsController.class);
    }
}
