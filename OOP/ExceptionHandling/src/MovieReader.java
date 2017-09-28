import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by julia on 03-Mar-17.
 */
public class MovieReader {
    public static void main(String[] args){
        new MovieReader().doMagic();

    }

    public void doMagic(){
        boolean successfull = false;
        List<Movie> movies = new ArrayList<>();
        while(!successfull){
            System.out.println("Please enter the file for them moviez!\n");
            Scanner console = new Scanner(System.in);
            String filename = console.nextLine();
            movies.clear();
            try{
                List<String> lines = parseLines(filename);
                if(lines.size()<=0)
                    throw new FileHasErrorsException("There were no lines");
                String[] header = lines.get(0).split(",");
                if(header.length>4)
                    throw new FileHasErrorsException("You have set to many values. I can only handle 4 per line");

                for(int i = 1; i<lines.size();i++){
                    String[] curLine = lines.get(i).split(",");
                    if(header.length!=curLine.length)
                        throw new FileHasErrorsException(String.format("Line %d was invalid. had different size than header", i));
                    Movie movie = new Movie();
                    for(int j = 0; j<header.length;j++){
                        switch (header[j]) {
                            case "id":
                                appendId(curLine[j], movie);
                                break;
                            case "title":
                                appendTitle(curLine[j], movie);
                                break;
                            case "country":
                                appendCountry(curLine[j], movie);
                                break;
                            case "year":
                                appendYear(curLine[j], movie);
                                break;
                            default:
                                throw new FileHasErrorsException("Unknown item in header. Valid items are 'id', 'title', 'country', 'year'");
                        }
                    }
                    movies.add(movie);
                }
                System.out.println("You have done it, woah I'm proud my son");
                successfull=true;

            }catch(FileHasErrorsException ex){
                System.out.println("There was a valid file, with invalid input. File had an error exception happened :O"
                        + ex.getMessage());
                successfull = false;
            }catch(IOException ex){
                System.out.println("Invalid file"+ex.getMessage());
                successfull = false;
            }
            System.out.println("Movies:");
            for (Movie mov:movies) {
                System.out.println(mov.getDescriptiom());
            }
        }
    }

    private List<String> parseLines(String filename) throws IOException{
        return Files.readAllLines(Paths.get(filename));
    }

    private void appendId(String id, Movie movie){
        movie.setId(id);
    }
    private void appendYear(String year, Movie movie) throws FileHasErrorsException {
        try {
            movie.setYear(Integer.parseInt(year));
        }
        catch(NumberFormatException ex){
            throw new FileHasErrorsException("Year can not be converted woah ey");
        }
    }
    private void appendTitle(String title, Movie movie){
        movie.setTitle(title);
    }
    private void appendCountry(String country, Movie movie){
        movie.setCountry(country);
    }
}
