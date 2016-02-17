package org.ict4h.service;

import org.ict4h.domain.AppConfig;
import org.ict4h.domain.AppConfigs;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;

@Component
public class AppConfiguration {

        private AppConfigs appconfigs= new AppConfigs();
        public AppConfiguration() {

            try {
                InputStream in = this.getClass().getClassLoader().getResourceAsStream("Apps.yml");
                Constructor constructor=new Constructor(AppConfig.class);
                Yaml yaml = new Yaml(constructor);

                for( Object data : yaml.loadAll(in)) {

                    AppConfig obj=(AppConfig) data;
                    appconfigs.add(obj);
                }
            }

            catch (Exception e){
                throw e;
            }

        }
        public AppConfigs getAppDetails(){
            return appconfigs;
        }


}