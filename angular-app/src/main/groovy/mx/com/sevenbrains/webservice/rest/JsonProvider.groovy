package mx.com.sevenbrains.webservice.rest
import org.codehaus.jackson.jaxrs.JacksonJsonProvider
import org.codehaus.jackson.map.ObjectMapper
import org.codehaus.jackson.map.SerializationConfig
import org.springframework.stereotype.Component

import javax.ws.rs.core.MediaType
import javax.ws.rs.ext.Provider
import java.text.SimpleDateFormat
/**
 * Created by lordluzbel on 3/03/14.
 */
@Component
@Provider
class JsonProvider extends JacksonJsonProvider{
    final DATE_FORMAT = "dd/MM/yyyy hh:mm:ss a"

    @Override
    ObjectMapper locateMapper(Class<?> type, MediaType mediaType) {
        def mapper = super.locateMapper(type, mediaType)
        def serializationConfig = mapper.getSerializationConfig()
        def deserializationConfig = mapper.getDeserializationConfig()
        def dateFormat = new SimpleDateFormat(DATE_FORMAT)

        serializationConfig.setDateFormat(dateFormat)
        deserializationConfig.setDateFormat(dateFormat)
        mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false)
        return mapper
    }
}
