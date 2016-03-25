package org.ababup1192;

import com.mongodb.MongoClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(Enclosed.class)
public class OperatorTest {
    private static final String DATA_STORE_NAME = "parameterized";


    public static class SmallDataSetTest {

        private static final int NUM_OF_DATA_SET = 100;

        @Before
        public void preProcess() throws Exception {
            final Morphia morphia = new Morphia();

            MongoClient mongoClient = new MongoClient();
            mongoClient.dropDatabase(DATA_STORE_NAME);

            final Datastore datastore = morphia.createDatastore(new MongoClient(), DATA_STORE_NAME);

            List<Entity> entities1 = new ArrayList<>();
            List<Entity> entities2 = new ArrayList<>();
            List<Entity> entities3 = new ArrayList<>();

            for (int i = 0; i < NUM_OF_DATA_SET; i++) {
                entities1.add(new Entity(
                                new IntegerParameter(i + 1, 1, false, new Date(), new Date()),
                                new StringParameter("name" + i + 1, 1, false, new Date(), new Date()),
                                new BooleanParameter(true, 1, false, new Date(), new Date())
                        )
                );
            }

            for (int i = NUM_OF_DATA_SET; i < NUM_OF_DATA_SET * 2; i++) {
                entities2.add(new Entity(
                                new IntegerParameter(i + 1, 1, false, new Date(), new Date()),
                                new StringParameter("name" + i + 1, 1, false, new Date(), new Date()),
                                new BooleanParameter(true, 1, false, new Date(), new Date())
                        )
                );
            }

            for (int i = NUM_OF_DATA_SET * 2; i < NUM_OF_DATA_SET * 3; i++) {
                entities3.add(new Entity(
                                new IntegerParameter(i + 1, 1, false, new Date(), new Date()),
                                new StringParameter("name" + i + 1, 1, false, new Date(), new Date()),
                                new BooleanParameter(true, 1, false, new Date(), new Date())
                        )
                );
            }

            datastore.save(new EntityGroup(entities1));
            datastore.save(new EntityGroup(entities2));
            datastore.save(new EntityGroup(entities3));
        }

        @Test
        public void testSelect() {
            final Morphia morphia = new Morphia();
            final Datastore datastore = morphia.createDatastore(new MongoClient(), DATA_STORE_NAME);
            final Query<EntityGroup> query = datastore.createQuery(EntityGroup.class)
                    .filter("entities.id.value >", NUM_OF_DATA_SET);

            assertThat(query.asList().size(), is(2));
        }
    }

    public static class MiddleDataSetTest {

        private static final int NUM_OF_DATA_SET = 10000;

        @Before
        public void preProcess() throws Exception {
            final Morphia morphia = new Morphia();

            MongoClient mongoClient = new MongoClient();
            mongoClient.dropDatabase(DATA_STORE_NAME);

            final Datastore datastore = morphia.createDatastore(new MongoClient(), DATA_STORE_NAME);

            List<Entity> entities1 = new ArrayList<>();
            List<Entity> entities2 = new ArrayList<>();
            List<Entity> entities3 = new ArrayList<>();

            for (int i = 0; i < NUM_OF_DATA_SET; i++) {
                entities1.add(new Entity(
                                new IntegerParameter(i + 1, 1, false, new Date(), new Date()),
                                new StringParameter("name" + i + 1, 1, false, new Date(), new Date()),
                                new BooleanParameter(true, 1, false, new Date(), new Date())
                        )
                );
            }

            for (int i = NUM_OF_DATA_SET; i < NUM_OF_DATA_SET * 2; i++) {
                entities2.add(new Entity(
                                new IntegerParameter(i + 1, 1, false, new Date(), new Date()),
                                new StringParameter("name" + i + 1, 1, false, new Date(), new Date()),
                                new BooleanParameter(true, 1, false, new Date(), new Date())
                        )
                );
            }

            for (int i = NUM_OF_DATA_SET * 2; i < NUM_OF_DATA_SET * 3; i++) {
                entities3.add(new Entity(
                                new IntegerParameter(i + 1, 1, false, new Date(), new Date()),
                                new StringParameter("name" + i + 1, 1, false, new Date(), new Date()),
                                new BooleanParameter(true, 1, false, new Date(), new Date())
                        )
                );
            }

            datastore.save(new EntityGroup(entities1));
            datastore.save(new EntityGroup(entities2));
            datastore.save(new EntityGroup(entities3));
        }

        @Test
        public void testSelect() {
            final Morphia morphia = new Morphia();
            final Datastore datastore = morphia.createDatastore(new MongoClient(), DATA_STORE_NAME);
            final Query<EntityGroup> query = datastore.createQuery(EntityGroup.class)
                    .filter("entities.id.value >", NUM_OF_DATA_SET);

            assertThat(query.asList().size(), is(2));
        }
    }

    public static class LargeDataSetTest {

        private static final int NUM_OF_DATA_SET = 50000;

        @Before
        public void preProcess() throws Exception {
            final Morphia morphia = new Morphia();

            MongoClient mongoClient = new MongoClient();
            mongoClient.dropDatabase(DATA_STORE_NAME);

            final Datastore datastore = morphia.createDatastore(new MongoClient(), DATA_STORE_NAME);

            List<Entity> entities1 = new ArrayList<>();
            List<Entity> entities2 = new ArrayList<>();
            List<Entity> entities3 = new ArrayList<>();

            for (int i = 0; i < NUM_OF_DATA_SET; i++) {
                entities1.add(new Entity(
                                new IntegerParameter(i + 1, 1, false, new Date(), new Date()),
                                new StringParameter("name" + i + 1, 1, false, new Date(), new Date()),
                                new BooleanParameter(true, 1, false, new Date(), new Date())
                        )
                );
            }

            for (int i = NUM_OF_DATA_SET; i < NUM_OF_DATA_SET * 2; i++) {
                entities2.add(new Entity(
                                new IntegerParameter(i + 1, 1, false, new Date(), new Date()),
                                new StringParameter("name" + i + 1, 1, false, new Date(), new Date()),
                                new BooleanParameter(true, 1, false, new Date(), new Date())
                        )
                );
            }

            for (int i = NUM_OF_DATA_SET * 2; i < NUM_OF_DATA_SET * 3; i++) {
                entities3.add(new Entity(
                                new IntegerParameter(i + 1, 1, false, new Date(), new Date()),
                                new StringParameter("name" + i + 1, 1, false, new Date(), new Date()),
                                new BooleanParameter(true, 1, false, new Date(), new Date())
                        )
                );
            }

            datastore.save(new EntityGroup(entities1));
            datastore.save(new EntityGroup(entities2));
            datastore.save(new EntityGroup(entities3));
        }

        @Test
        public void testSelect() {
            final Morphia morphia = new Morphia();
            final Datastore datastore = morphia.createDatastore(new MongoClient(), DATA_STORE_NAME);
            final Query<EntityGroup> query = datastore.createQuery(EntityGroup.class)
                    .filter("entities.id.value >", NUM_OF_DATA_SET);

            assertThat(query.asList().size(), is(2));
        }
    }
}
