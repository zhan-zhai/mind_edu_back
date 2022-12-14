package application.repository;

import application.model.*;
import org.apache.jena.dboe.migrate.L;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface NodeRepository extends Neo4jRepository<Node, Long> {
    @Query("MATCH (n:Node) where ID(n)={0} return n")
    Node findByNodeLongId(Long id);

    @Query("MATCH (n:Node) WHERE n.course_mindmap = ({course_mindmap}) and n.node_id=({node_id}) RETURN n")
    Node findByNodeId(@Param("course_mindmap") String course_mindmap, @Param("node_id") String node_id);

    @Query("start node = node({id}) match (node)-[:HAS_COURSEWARE]->(coursewares) return coursewares")
    Courseware[] findCoursewares(@Param("id") long id);

    @Query("match (n:Node) - [:HAS_LINK] - (l:Link) where id(n) = {0} return l")
    Link[] findLinks(long id);

    @Query("start node = node({id}) match (node)-[:HAS_MATERIAL]->(materials) return materials")
    Material[] findMaterials(@Param("id") long id);

    ////////////
    @Query("start node = node({id}) match (node)-[:HAS_ASSIGNMENT_MULTI]->(ass_multi) return ass_multi")
    AssignmentMultiple[] findAssignmentMultiple(@Param("id") long id);

    @Query("match (n:Node) - [h:HAS_ASSIGNMENT_JUDGMENT] - (j:Assignment_judgment) where ID(n) = {0} return j")
    AssignmentJudgment[] findAssignmentJudgments(long id);

    @Query("start node = node({id}) match (node)-[:HAS_ASSIGNMENT_SHORT]->(ass_short) return ass_short")
    AssignmentShort[] findAssignmentShort(@Param("id") long id);
    ////////////

    @Query("start node = node({id}) match (node)-[:HAS_CHILD]->(children) return children")
    Node[] findChildren(@Param("id") long id);

    @Query("start node = node({id}) match (node)-[:HAS_NOTE]->(notes) return notes")
    Note[] findNotes(@Param("id") long id);

    //改：根据某选择题删除HAS_ASSIGNMENT_MULTI关系（一般只删一个）
    @Query("match(n:Node)-[i:HAS_ASSIGNMENT_MULTI]->(a:Assignment_multiple) where ID(n)={0} and ID(a)={1} delete i")
    void deleteNodeToMultiple(@Param("long_id") Long long_id,@Param("id") Long id);

    //改：根据某选择题删除HAS_ASSIGNMENT_JUDGMENT关系（一般只删一个）
    @Query("match(n:Node)-[i:HAS_ASSIGNMENT_JUDGMENT]->(a:Assignment_judgment) where ID(n)={0} and ID(a)={1} delete i")
    void deleteNodeToJudgement(@Param("long_id") Long long_id,@Param("id") Long id);

    //改：根据某选择题删除HAS_ASSIGNMENT_SHORT关系（一般只删一个）
    @Query("match(n:Node)-[i:HAS_ASSIGNMENT_SHORT]->(a:Assignment_short) where ID(n)={0} and ID(a)={1} delete i")
    void deleteNodeToShort(@Param("long_id") Long long_id,@Param("id") Long id);

    //改：只要是这个节点的选择题，都找到

}
