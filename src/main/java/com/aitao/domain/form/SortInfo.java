package com.aitao.domain.form;

import lombok.Data;

/**
 * Created with of666.
 * User: of666
 * Date: 2015/10/31 0031
 * Time: 10:59
 */
@Data
public class SortInfo {
    public String field;

    public String sort;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SortInfo{");
        sb.append("field='").append(field).append('\'');
        sb.append(", sort='").append(sort).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
