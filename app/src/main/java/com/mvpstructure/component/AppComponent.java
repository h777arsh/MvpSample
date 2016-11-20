package com.mvpstructure.component;

import com.mvpstructure.activities.MainActivity;
import com.mvpstructure.networking.ApplicationModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * @author Harsh
 * @version 1.0
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface AppComponent {

  void inject(MainActivity activity);
}
