package edu.jhu.thrax.hadoop.features;

import edu.jhu.thrax.hadoop.datatypes.RuleWritable;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class LexicalityFeature extends SimpleFeature
{
    private static final Text LABEL = new Text("Lexical");
    private static final IntWritable ZERO = new IntWritable(0);
    private static final IntWritable ONE = new IntWritable(1);

    public LexicalityFeature()
    {
        super("lexical");
    }

    public void score(RuleWritable r)
    {
        for (String tok : r.source.toString().split("\\s+")) {
            if (tok.startsWith("[")) {
                r.features.put(LABEL, ZERO);
                return;
            }
        }
        for (String tok : r.target.toString().split("\\s+")) {
            if (tok.startsWith("[")) {
                r.features.put(LABEL, ZERO);
                return;
            }
        }
        r.features.put(LABEL, ONE);
        return;
    }
}
