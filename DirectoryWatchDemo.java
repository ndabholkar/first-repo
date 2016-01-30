package examples.misc;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class DirectoryWatchDemo {

	public static void main(String[] args) {
		try (WatchService watcher = FileSystems.getDefault().newWatchService();) {
			Path dir = Paths.get("c:/workspace/Sunrise");
			dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

			System.out.println("Watch Service registered for dir: " + dir.getFileName());

			while (true) {
				WatchKey key;
				try {
					key = watcher.take();
				} catch (InterruptedException ex) {
					return;
				}

				for (WatchEvent<?> event : key.pollEvents()) {
					WatchEvent.Kind<?> kind = event.kind();

					if (kind == OVERFLOW) {
			            continue;
			        }
					
					WatchEvent<Path> ev = (WatchEvent<Path>) event;
					Path fileName = ev.context();

					System.out.println(kind.name() + ": " + fileName);

					 if (kind == ENTRY_CREATE) {
			 
			            // process create event
			 
			        } else if (kind == ENTRY_DELETE) {
			 
			            // process delete event
			 
			        } else if (kind == ENTRY_MODIFY) {
			 
			            // process modify event
			 
			        }
				}

				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}

		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
}
