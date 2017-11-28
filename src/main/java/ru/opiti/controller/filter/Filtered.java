package ru.opiti.controller.filter;

import ru.opiti.technics.model.Technics;

import java.util.List;

// Возможно стоит вынести запросы к отбору данных из БД в отдельную группу классов.
public interface Filtered {

    List<Technics> filter(String searchString);

}
