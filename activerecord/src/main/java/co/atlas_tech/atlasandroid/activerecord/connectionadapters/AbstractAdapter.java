package co.atlas_tech.atlasandroid.activerecord.connectionadapters;

import android.os.Bundle;

import java.util.List;

import co.atlas_tech.atlasandroid.activerecord.ActiveRecord;
import co.atlas_tech.atlasandroid.activerecord.ActiveRelation;
import co.atlas_tech.atlasandroid.activesupport.annotations.Beta;

/**
 * @author Rodrigo Scomasson do Nascimento <rodrigo.sc.na@gmail.com>
 */
@Beta
public abstract class AbstractAdapter {
    protected Bundle mConnectionSettings;

    /**
     * Sets the adapter connection settings if needed.
     *
     * @param connectionSettings A Bundle object containing the connection
     *                           settings for the adapter.
     */
    public void setConnectionSettings(Bundle connectionSettings) {
        mConnectionSettings = connectionSettings;
    }

    /**
     * Initializes the connection with the database.
     */
    public abstract void initializeConnection();

    /**
     * Closes all database connections and terminates them.
     */
    public abstract void terminateConnection();

    /**
     * Starts a transaction within the database connection.
     */
    public abstract void beginTransaction();

    /**
     * Sets the transaction as successful and commits all changes to the database.
     */
    public abstract void commitTransaction();

    /**
     * Sets the transaction as unsuccessful and cancel all changes to the database.
     */
    public abstract void rollbackTransaction();

    /**
     * Fetch all records based on your ActiveRelation query.
     *
     * @param activeRelation The ActiveRelation instance.
     * @param type           Model class type for query and returning objects.
     * @return The list of records fetched from the database.
     */
    public abstract <T extends ActiveRecord> List<T> all(ActiveRelation activeRelation, Class<T> type);

    /**
     * Fetch the first database record based on your ActiveRelation query.
     *
     * @param activeRelation The ActiveRelation instance.
     * @param type           Model class type for query and returning objects.
     * @return The first record fetched from the database.
     */
    public abstract <T extends ActiveRecord> T first(ActiveRelation activeRelation, Class<T> type);

    /**
     * Fetch the last database record based on your ActiveRelation query.
     *
     * @param activeRelation The ActiveRelation instance.
     * @param type           Model class type for query and returning objects.
     * @return The last record fetched from the database.
     */
    public abstract <T extends ActiveRecord> T last(ActiveRelation activeRelation, Class<T> type);

    /**
     * Converts your ActiveRelation query to a SQL String.
     *
     * @param activeRelation The ActiveRelation instance.
     * @param type           Model class type for query.
     * @return The SQL equivalent to your ActiveRelation.
     */
    public abstract <T extends ActiveRecord> String toSQL(ActiveRelation activeRelation, Class<T> type);
}
