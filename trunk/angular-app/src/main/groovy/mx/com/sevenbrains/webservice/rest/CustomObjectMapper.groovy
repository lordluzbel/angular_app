package mx.com.sevenbrains.webservice.rest

import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.map.SerializationConfig

/**
 * Created by lordluzbel on 3/03/14.
 */
class CustomObjectMapper extends ObjectMapper{
    CustomObjectMapper(){
        super()
        configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false)
    }
}
