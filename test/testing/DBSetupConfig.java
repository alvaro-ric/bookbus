/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DriverManagerDestination;
import com.ninja_squad.dbsetup.operation.Operation;

/**
 *
 * @author Philip
 */
public class DBSetupConfig {
    public void executeOperation(Operation operation) {
        DbSetup dbSetup = new DbSetup(new DriverManagerDestination(
                "jdbc:postgresql://localhost:5432/boobus", 
                "postgres", 
                "philip12"), operation);
        dbSetup.launch();
    }
}
