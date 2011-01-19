package edu.jhu.thrax.hadoop.features;

import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

import edu.jhu.thrax.hadoop.datatypes.RuleWritable;

public abstract class SimpleFeature extends Feature
{
    public SimpleFeature(String name)
    {
        super(name);
    }

    public abstract void score(RuleWritable r);

    public abstract void score(RuleWritable r, Map<Text,Writable> map);
}

