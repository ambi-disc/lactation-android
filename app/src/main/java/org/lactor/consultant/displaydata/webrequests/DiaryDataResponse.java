package org.lactor.consultant.displaydata.webrequests;

import org.lactor.consultant.displaydata.model.BreastfeedEntry;
import org.lactor.consultant.displaydata.model.MorbidityEntry;
import org.lactor.consultant.displaydata.model.OutputEntry;
import org.lactor.consultant.displaydata.model.SupplementEntry;

import java.util.List;

/**
 * @Author Matthew Page
 * @Date 11/19/17
 */

public class DiaryDataResponse {
    public List<BreastfeedEntry> breastfeedEntries;
    public List<SupplementEntry> supplementEntries;
    public List<OutputEntry> outputEntries;
    public List<MorbidityEntry> morbidityEntries;
}
