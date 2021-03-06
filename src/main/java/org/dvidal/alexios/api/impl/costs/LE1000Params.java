/*
 * Copyright (C) 2021 David Vidal Escudero - Free Open Source Software Consultancy
 *
 *       This program is free software: you can redistribute it and/or modify
 *       it under the terms of the GNU General Public License as published by
 *       the Free Software Foundation, either version 3 of the License, or
 *       (at your option) any later version.
 *
 *       This program is distributed in the hope that it will be useful,
 *       but WITHOUT ANY WARRANTY; without even the implied warranty of
 *       MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *       GNU General Public License for more details.
 *
 *       You should have received a copy of the GNU General Public License
 *       along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.dvidal.alexios.api.impl.costs;

import com.google.api.services.sheets.v4.model.Sheet;

/**
 * Inner record to retrieve required parameters from a spreadsheet.
 *
 * @version 1.0
 */
record LE1000Params(String ruc, String year, String ops) {
    /**
     * Creates this record from the main worksheet of the spreadsheet.
     *
     * @param aSheet the main worksheet.
     * @return a record with ruc, year and ops.
     */
    static LE1000Params fromSheet(Sheet aSheet) {
        var data = aSheet.getData().get(0).getRowData();
        var ruc = data.get(4).getValues().get(1).getFormattedValue();
        var year = data.get(5).getValues().get(1).getFormattedValue();
        var ops = data.get(6).getValues().get(1).getFormattedValue();
        return new LE1000Params(ruc, year, ops);
    }
}
