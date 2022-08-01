package main.java.MainApp;

import main.java.Controllers.ActivityController;
import main.java.Controllers.InterestController;
import main.java.Controllers.UserController;
import main.java.Entity.*;
import main.java.enums.AccountStatus;
import main.java.enums.ArticleStatus;
import main.java.enums.UserTitle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;*/


/**
 * Cette classe implemente les tests unitaires du logiciel
 * @author Fannie Filion-Bienvenue
 * @version 1.0
 */

public class MenuTest {

    // Instanciating members, lists and controllers
        Member gabriel =  new Member(0, "gabriel", "test", null, null, 
                "goole.com", UserTitle.Master, "test@umontreal.ca", null);
        Member eugene = new Member(5, "Eugene", "Syriani", null, null,
                "https://geodes.iro.umontreal.ca/", UserTitle.Professor, "eugene.syriani@umontreal.ca", null);
        Member houari = new Member(6, "Houari", "Sahraoui", null, null,
                "https://geodes.iro.umontreal.ca/", UserTitle.Professor, "houari.sahraoui@umontreal.ca", null);
        Member istvanUser = new Member(7, "Istvan", "David", null, null,
                "https://geodes.iro.umontreal.ca/", UserTitle.PHD, "istvan.david@umontreal.ca", null);
        Member louisUser = new Member(8, "Louis-Edouard", "Lafontant", null, null,
                "https://geodes.iro.umontreal.ca/", UserTitle.PHD, "louis.edouard.lafontant@umontreal.ca", null);
    
    List <User> users = new ArrayList<>();
    List <Account> accounts = new ArrayList<>();
    List<Activity> activities = new ArrayList<>();  
    List<Interest> interests = new ArrayList<>();
    ActivityController activityController = new ActivityController(activities);
    UserController userController = new UserController(users, accounts);
    InterestController interestController = new InterestController(interests);
    

    //                              ***      Tests for member #1: Gabriel     ***
    @Test 
    public void testCreateAccount() {

        // Create dummy informations
        String tel = "5145554444";
        String pw = "pw";
        Professor michalis = new Professor(4, "Michalis", "Famelis", null, null,
                "https://geodes.iro.umontreal.ca/", UserTitle.Professor, "michalis.famelis@umontreal.ca");
                
        // Verify that the state of the databases are correct 
        assertTrue(accounts.size() == 0);
        assertTrue(users.size() == 0);
        int sizeBeforeAdd = accounts.size();

        // Test the function itself
        userController.createAccount(michalis.getFname(), michalis.getLname(), michalis.getEmail(), tel, pw, michalis);
        int sizeAfterAdd = accounts.size();

        // Verify that the state of the databases are correct 
        assertTrue(sizeBeforeAdd + 1 == sizeAfterAdd);
        assertNotNull(users.size());
    }


    //                              ***      Tests for member #2: Eugene     ***
    @Test
    public void testUser() {

        // Get the state of the database
        int sizeBeforeAdd = users.size();

        // Test the addUser function 
        userController.addUser(eugene);

        // Verify that the state of the database is correct
        assertTrue(sizeBeforeAdd + 1 == users.size());

         // Fetch user to compare and simoultaneously test the getFname function
         User user = users.get(0);
         String userName = user.getFname();
         assertTrue("Eugene" == userName);
         
         // Test the getUserByName function 
         User test = userController.getUserByName(userName);
         assertEquals(user, test);

    }


    //                              ***      Tests for member #3: Houari     ***
    @Test 
    public void testInterest() {

        // To verify that the state of the database is correct
        int sizeBeforeAdd = interests.size();

        // Test the function addInterest 
        interestController.addInterest("test", "idk");

         // Verify that the state of the database is correct
         int sizeAfterAdd = interests.size();
         assertTrue(sizeBeforeAdd + 1 == sizeAfterAdd);

         // Verify that the added interest is the good one and simoultaneously test the getName function
         String name = interests.get(0).getName();
         assertEquals(name, "test");

         // Test the function deleteInterest
         interestController.deleteInterest(name);
         int sizeAfterDelete = interests.size();
         assertTrue(sizeAfterAdd - 1 == sizeAfterDelete);

    }

    
    //                              ***      Tests for member #4: istvanUser     ***
    @Test 
    public void testLogin() {

        // Create account for itsvanUser (functions tested for member #1 and #2)
        int sizeBeforeAdd = accounts.size();
        userController.createAccount(istvanUser.getFname(), istvanUser.getLname(), istvanUser.getEmail(),
        "514555555", "pw", null);
        int sizeAfterAdd = accounts.size();

        // Verify that the state of the database is correct
        assertTrue(sizeBeforeAdd + 1 == sizeAfterAdd);

        // Get the user's information and simoultaneously test the getPassword and getEmail functions
        User user = users.get(0);
        String pw = accounts.get(0).getPassword();
        String email = accounts.get(0).getEmail();
       
        // Create dummy email 
        String fakeEmail = "wrong@google.com";

        // Test the function itself
        User test = userController.login(email, pw, AccountStatus.PENDING);
        assertEquals(user, test);

        User test2 = userController.login(fakeEmail, pw, AccountStatus.PENDING);
        assertEquals(null, test2);

    }


    //                              ***      Tests for member #5: louisUser     ***
    @Test
    public void testArticle() {

        // Verify that the state of the database is correct       
        assertTrue(activities.size() == 0);

        // Create dummy article
        Article article = new Article("test",
        new Date(1996, 2 , 4),
        "okok.html",
        ArticleStatus.Published,
        new ArrayList<User>(Arrays.asList()),
        new ArrayList<User>(Arrays.asList()),
        new ArrayList<String>(Arrays.asList("test")),
        new ArrayList<Interest>(),
        "Test",
        1
        );

        activities.add(article);

        // Verify that the state of the database is correct 
        assertTrue(activities.size() == 1);

        // Fetch all articles
        List<Article> articles = activityController.getAllArticle();

        // Verify that the state of the database is correct
        assertTrue(articles.size() > 0);

        // Pick an article to modify and simoultaneously test the getTitle and getId functions
        Article articleToModify = articles.get(0);
        String articleTitleBefore = articleToModify.getTitle();
        int articleId = articleToModify.getId();

        // Test the function itself
        activityController.modifyArticle("Modified", "", "", null, 
        null, null, null, null, null, articleId);

        // Verify that the state of the database is correct
        String articleTitleAfter = articleToModify.getTitle();
        assertTrue(articleTitleAfter != articleTitleBefore);

    }
}
