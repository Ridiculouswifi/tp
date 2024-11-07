package seedu.commands;

import seedu.duke.Internship;

import java.util.ArrayList;
import java.util.logging.Level;

public class FavouriteCommand extends Command {
    @Override
    public void execute(ArrayList<String> args) {

        for (String arg : args) {
            try {
                int internshipId = Integer.parseInt(arg);
                int internshipIndex = internshipId - 1;
                Internship internship = internships.getInternship(internshipIndex);
                ArrayList<Internship> favouriteInternships = internships.favouriteInternships;
                if (internship == null) {
                    continue;
                }
                if (favouriteInternships.contains(internship)) {
                    continue;
                }
                favouriteInternships.add(internship);

                logger.log(Level.INFO, "FavouriteCommand Executed");
            } catch (NumberFormatException e) {
                uiCommand.showOutput("Invalid integer: " + arg + "\nPlease provide a valid internship ID");
            }
        }
        if (args.isEmpty()) {
            uiCommand.showEmptyFlags();
            return;
        }
        internships.listFavouriteInternshipsBySortedByID();
        uiCommand.showOutput("The list of favourite internships have been displayed above");
    }

    // rahul can change here also
    @Override
    public String getUsage() {
        return """
                filter
                Usage: filter -{flag} {field data}""";
    }
}
