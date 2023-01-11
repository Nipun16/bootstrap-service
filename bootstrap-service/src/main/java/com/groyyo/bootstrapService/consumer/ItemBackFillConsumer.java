/**
 * 
 */
package com.groyyo.bootstrapService.consumer;

import java.util.Objects;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.context.annotation.Lazy;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.groyyo.core.kafka.consumer.BaseConsumer;

import lombok.extern.log4j.Log4j2;

/**
 * @author naveen.kumar
 *
 * @date 12-Nov-2019
 *
 **/
@Log4j2
@Service
@Lazy(false)
public class ItemBackFillConsumer<T> extends BaseConsumer<T> {

	//@KafkaListener(topics = { "${item.backfill.error.topic}" }, idIsGroup = false, id = "item-master-back-fill-errors")
	public void receive(ConsumerRecords<String, String> records) {

		if (records != null && !records.isEmpty()) {

			log.debug("Received " + records.count() + " record(s) to process");

			try {

				for (ConsumerRecord<String, String> record : records) {
					log.info("Data consumed is {}", record);

					try {
						if (Objects.nonNull(record.value())) {

							// do something

						} else {
							log.warn("Warning message");
						}
					} catch (Exception ex) {
						log.error("Error message ", ex);
					}
				}
			} catch (Exception e) {
				log.error("Error message : ", e);
			}

		}

	}
}