package queries;

import com.vaticle.typedb.client.TypeDB;
import com.vaticle.typedb.client.api.TypeDBClient;
import com.vaticle.typedb.client.api.TypeDBSession;
import com.vaticle.typedb.client.api.TypeDBTransaction;
import com.vaticle.typedb.client.api.answer.ConceptMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.vaticle.typeql.lang.TypeQL.parseQuery;

public class RouteSensor {
	public void routeSensor(){
		TypeDBClient client = TypeDB.coreClient("localhost:1729");
		TypeDBSession session = client.session("Train2", TypeDBSession.Type.DATA);
		TypeDBTransaction transaction = session.transaction(TypeDBTransaction.Type.WRITE);

		List<String> queryAsList = Arrays.asList(
			"match",
			"$req ($r, $s) isa requires;",
			"$r has id $r-x;",
			"$s has id $s-x;",
			"get $req;"
		);
		String query = String.join("", queryAsList);
		List<String> result = new ArrayList<>();

		List<ConceptMap> answers = transaction.query().match(parseQuery(query).asMatch()).collect(Collectors.toList());
		for (ConceptMap answer : answers) {
			result.add(
				answer.get("id").asThing().asAttribute().getValue().toString()
			);
		}

		System.out.println("\nResult:\n" + String.join(", ", result));

		transaction.close();
		session.close();
		client.close();
	}
}
