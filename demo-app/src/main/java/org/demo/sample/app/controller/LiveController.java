package org.demo.sample.app.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

@RestController
@RequestMapping("/live")
public class LiveController {

    // https://stackoverflow.com/questions/51370463/spring-webflux-flux-how-to-publish-dynamically

    private FluxProcessor<String, String> processor = DirectProcessor.create();
    private FluxSink<String> sink = processor.sink();

    @PostMapping
    public void createEvent(String data) {
        sink.next(data);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getEvents() {
        return processor;
    }

}
