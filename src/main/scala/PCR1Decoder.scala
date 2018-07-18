import com.typesafe.scalalogging.LazyLogging
import org.loraalliance.Decoder
import spray.json._

class PCR1Decoder extends Decoder with LazyLogging {
  override def execute(payload: String, format: PayloadFormat = PayloadFormat.HEX): JsObject = {
    logger.debug(s"Payload: $payload")

    if (format != PayloadFormat.HEX) {
      throw new IllegalStateException(s"Unsupported format $format")
    }

    val value = Hex2Dec(payload.substring(2, 6))

    val result = JsObject(
      "count" -> JsNumber(value),
      "payload" -> JsString(payload),

      "ipso" -> JsObject(
        // Counter Sensor
        "3300" -> JsObject(
          "5534" -> JsNumber(value)
        )
      )
    )

    logger.debug(s"Result: $result")

    result
  }
}
