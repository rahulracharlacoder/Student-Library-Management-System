package com.lms.Library_Management_System.converter;

import com.lms.Library_Management_System.dto.CardDTO;
import com.lms.Library_Management_System.model.Card;

public class CardConverter {

    public static Card CardDTOIntoCard(CardDTO cardDTO) {

        Card card = Card.builder().
                cardStatus(cardDTO.getCardStatus()).
                build();

        return card;
    }
}
