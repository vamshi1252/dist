package com.crossover.trial.properties;

import com.crossover.trial.exception.ConfigException;
import com.crossover.trial.factory.ParserFactory;
import com.crossover.trial.parser.Parser;
import com.crossover.trial.reader.Reader;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author code test administrator
 */
@Slf4j
public class TrialAppPropertiesManager implements AppPropertiesManager {

    private static final Reader reader             = new Reader();

    private TrialAppProperties  trialAppProperties = new TrialAppProperties();

    public static void main(String[] args) {
        TrialAppPropertiesManager tp = new TrialAppPropertiesManager();
        List<String> propUris = new ArrayList<String>();
        propUris.add("file:///Users/vamshi.vijay/codebase/test/properties-dist/src/main/resources/aws.properties");
        tp.loadProps(propUris);
    }

    @Override
    public AppProperties loadProps(List<String> propUris) {
        trialAppProperties = new TrialAppProperties();
        if (CollectionUtils.isNotEmpty(propUris)) {
            for (String path : propUris) {
                try {
                    String type = path.split(":")[0];
                    InputStream inputStream = reader.getStream(type, path);
                    if (inputStream == null) {
                        throw new ConfigException("Invalid Stream");
                    }
                    String[] extensions = path.split("\\.");
                    int len = extensions.length;
                    Parser parser = ParserFactory.getInstance(extensions[len - 1]);
                    if (parser == null) {
                        throw new ConfigException("Not a valid file extension");
                    }
                    log.info("Parsing file: [{}]", path);
                    parser.getProps(inputStream, trialAppProperties);
                } catch (ConfigException e) {
                    log.error("Exception occurred due to config problem in file: [{}]", path, e);
                    trialAppProperties.setFlag(false);
                }
            }
            log.info("List of properties loaded from input files [{}]", trialAppProperties);
        }
        return trialAppProperties;
    }

    @Override
    public void printProperties(AppProperties props, PrintStream sync) {
        sync.println(props);
    }

    public TrialAppProperties getTrialAppProperties() {
        return trialAppProperties;
    }
}
