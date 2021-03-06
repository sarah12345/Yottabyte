package com.thoughtworks.yottabyte;

import com.google.common.base.Preconditions;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;


public class ConfiguredReducer<K1,V1,K2,V2> extends Reducer<K1,V1,K2,V2> {
  private Configuration configuration;

  @Override
  protected void setup(Context context) throws IOException, InterruptedException {
    super.setup(context);
    configuration = context.getConfiguration();
  }


  protected String get(String key){
    return Preconditions.checkNotNull(configuration.get(key),
      "Expected %s to be present, but was not", key);
  }
}
