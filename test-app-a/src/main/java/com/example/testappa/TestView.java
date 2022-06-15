package com.example.testappa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;

@Route("")
public class TestView extends VerticalLayout {

	//private int counter = 0;
	private FeederThread thread;

	private Text countText = new Text("");

	private Text lastMessage = new Text("");

	@Autowired
	private Configs config;

	@PostConstruct
	public void createContents() {
		add(new Text(config.getTestLabel()));
	}

	public TestView() {
		add(new Text("Welcome to MainView."));
		add(this.getClickMe());
		add(countText);
		add(lastMessage);
	}

	@Override
    protected void onAttach(AttachEvent attachEvent) {
                // Start the data feed thread
        thread = new FeederThread(attachEvent.getUI(), this.lastMessage);
        thread.start();
    }


	private Button getClickMe() {
		Button clickMe = new Button("Click me!");
		clickMe.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {

			@Override
			public void onComponentEvent(ClickEvent<Button> event) {
				Counter counter = Counter.getInstance();
				counter.setCount(counter.getCount()+1);
				countText.setText("You clicked " + counter.getCount() + " times.");
			}
			
		});
		return clickMe;
	}

	private static class FeederThread extends Thread {
        private final UI ui;
        private final Text view;

        private int count = 0;

        public FeederThread(UI ui, Text view) {
            this.ui = ui;
            this.view = view;
        }

        @Override
        public void run() {
            try {
                // Update the data for a while
                while (count < 10) {
                    // Sleep to emulate background work
                    Thread.sleep(500);
                    String message = Receiver.lastMessage;

                    ui.access(() -> view.setText(message));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}